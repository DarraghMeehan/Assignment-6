/**
 * Created by G00285553 on 24/11/2015.
 */
// Fig. 8.37: AddressBookEntryFrame.java
// A subclass of JInternalFrame customized to display and
// an AddressBookEntry or set an AddressBookEntry's properties
// based on the current data in the UI.

// Java core packages
import java.util.*;
import java.awt.*;

// Java extension packages
import javax.swing.*;

public class AddressBookEntryFrame extends JInternalFrame {

    // HashMap to store JTextField references for quick access
    private HashMap fields;

    // current AddressBookEntry set by AddressBook application
    private AddressBookEntry person;

    // panels to organize GUI
    private JPanel leftPanel, rightPanel;

    // static integers used to determine new window positions
    // for cascading windows
    private static int xOffset = 0, yOffset = 0;

    // static Strings that represent name of each text field.
    // These are placed on JLabels and used as keys in
    // HashMap fields.
    private static final String FIRST_NAME = "First Name",
            LAST_NAME = "Last Name", ADDRESS1 = "Address 1",
            ADDRESS2 = "Address 2", CITY = "City", COUNTY = "County",
            PHONE = "Phone", EMAIL = "Email", ADDRESS1EXTRA = "Extra Address 1",
            ADDRESS2EXTRA = "Extra Address 2", CITYEXTRA = "Extra City",
            COUNTYEXTRA = "Extra County", PHONEEXTRA = "Alternate Phone",
            EMAILEXTRA = "Alternate Email";

    // construct GUI
    public AddressBookEntryFrame()
    {
        super( "Address Book Entry", true, true );

        fields = new HashMap();

        leftPanel = new JPanel();
        leftPanel.setLayout( new GridLayout( 14, 1, 0, 5 ) );
        rightPanel = new JPanel();
        rightPanel.setLayout( new GridLayout( 14, 1, 0, 5 ) );

        createRow( FIRST_NAME );
        createRow( LAST_NAME );
        createRow( ADDRESS1 );
        createRow( ADDRESS2 );
        createRow( CITY );
        createRow( COUNTY );
        createRow( ADDRESS1EXTRA );
        createRow( ADDRESS2EXTRA );
        createRow( CITYEXTRA );
        createRow( COUNTYEXTRA );
        createRow( PHONE );
        createRow( PHONEEXTRA );
        createRow( EMAIL );
        createRow( EMAILEXTRA );

        Container container = getContentPane();
        container.add( leftPanel, BorderLayout.WEST );
        container.add( rightPanel, BorderLayout.CENTER );

        setBounds( xOffset, yOffset, 400, 400 );
        xOffset = ( xOffset + 30 ) % 300;
        yOffset = ( yOffset + 30 ) % 300;
    }

    // set AddressBookEntry then use its properties to
    // place data in each JTextField
    public void setAddressBookEntry( AddressBookEntry entry )
    {
        person = entry;

        setField( FIRST_NAME, person.getFirstName() );//a
        setField( LAST_NAME, person.getLastName() );//b
        setField( ADDRESS1, person.getAddress1() );//c
        setField( ADDRESS2, person.getAddress2() );//d
        setField( CITY, person.getCity() );//e
        setField( COUNTY, person.getCounty() );//f
        setField( PHONE, person.getPhoneNumber() );//g
        setField( PHONEEXTRA, person.getPhoneNumberEXTRA() );//h
        setField( EMAIL, person.getEmailAddress() );//i
        setField( EMAILEXTRA, person.getEmailAddressEXTRA() );//j
        setField( ADDRESS1EXTRA, person.getAddress1EXTRA() );//k
        setField( ADDRESS2EXTRA, person.getAddress2EXTRA() );//l
        setField( CITYEXTRA, person.getCityEXTRA() );//m
        setField( COUNTYEXTRA, person.getCountyEXTRA() );//n
    }

    // store AddressBookEntry data from GUI and return
    // AddressBookEntry
    public AddressBookEntry getAddressBookEntry()
    {
        person.setFirstName( getField( FIRST_NAME ) );
        person.setLastName( getField( LAST_NAME ) );
        person.setAddress1( getField( ADDRESS1 ) );
        person.setAddress2( getField( ADDRESS2 ) );
        person.setCity( getField( CITY ) );
        person.setCounty( getField( COUNTY ) );
        person.setPhoneNumber( getField( PHONE ) );
        person.setPhoneNumberEXTRA( getField( PHONEEXTRA ) );
        person.setEmailAddress( getField( EMAIL ) );
        person.setEmailAddressEXTRA( getField( EMAILEXTRA ) );
        person.setAddress1EXTRA( getField( ADDRESS1EXTRA ) );
        person.setAddress2EXTRA( getField( ADDRESS2EXTRA ) );
        person.setCityEXTRA( getField( CITYEXTRA ) );
        person.setCountyEXTRA( getField( COUNTYEXTRA ) );

        return person;
    }

    // set text in JTextField by specifying field's
    // name and value
    private void setField( String fieldName, String value )
    {
        JTextField field =
                ( JTextField ) fields.get( fieldName );

        field.setText( value );
    }

    // get text in JTextField by specifying field's name
    private String getField( String fieldName )
    {
        JTextField field =
                ( JTextField ) fields.get( fieldName );

        return field.getText();
    }

    // utility method used by constructor to create one row in
    // GUI containing JLabel and JTextField
    private void createRow( String name )
    {
        JLabel label = new JLabel( name, SwingConstants.RIGHT );
        label.setBorder(
                BorderFactory.createEmptyBorder( 5, 5, 5, 5 ) );
        leftPanel.add( label );

        JTextField field = new JTextField( 30 );
        rightPanel.add( field );

        fields.put( name, field );
    }
}  // end class AddressBookEntryFrame


/**************************************************************************
 * (C) Copyright 2001 by Deitel & Associates, Inc. and Prentice Hall.     *
 * All Rights Reserved.                                                   *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/

