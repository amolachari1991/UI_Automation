package com.tests;

import com.pojo.AddressPojo;
import com.utility.FakeTestDataUtility;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.listeners.TestListner.class})
public class AddAddressTest extends TestBase{
    AddressPojo addressPojo;

    @Test
    public void addAddressTest(){
        addressPojo = new AddressPojo("abc","def","xyz","airport Road","next to indigo park area","Indiana","Indiana","12345","United States","9999999999","9999999999","EMPTY","Indiana");
        myAccountPage();
        String newAddress = myAccountPage.addMyFirstAddress().saveAddress(FakeTestDataUtility.addressFakeData());
        Assert.assertEquals(newAddress, "Your addresses are listed below.");
    }


}
