package com.zipcodewilmington.phone;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import org.omg.CORBA.DynAnyPackage.Invalid;

import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.*;

import java.util.logging.Logger;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        return new PhoneNumber[phoneNumberCount];
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {
        int areaCode = ThreadLocalRandom.current().nextInt(100,1000);
        int centralOfficeCode = ThreadLocalRandom.current().nextInt(100,1000);
        int phoneLineCode = ThreadLocalRandom.current().nextInt(1000,10000);
        return createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        StringBuilder fullPhoneNumber = new StringBuilder();
        String area = "(" + areaCode + ")";
        String hyphen = "-";
        fullPhoneNumber.append(area).append(hyphen).append(centralOfficeCode).append(hyphen).append(phoneLineCode);

    try {
        return createPhoneNumber(fullPhoneNumber.toString());
    }catch(InvalidPhoneNumberFormatException ex){
        logger.info(fullPhoneNumber + " is not a valid phone number");
        return null;
    }

    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        logger.info("Attempting to create a new PhoneNumber object with a value of " + phoneNumberString);
        PhoneNumber pN = new PhoneNumber(phoneNumberString);
//        return null;
        return pN;
    }
}
