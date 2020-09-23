package utils;

import nl.flotsam.xeger.Xeger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils
{
    /*
        Password pattern :
                - minimum 8 character
                - min 1 uppercase
                - min 1 lowercase
                - min 1 number
                - min 1 special character
     */
    private final static  String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}";

    //Email pattern (it includes letters with accents on username part)
    private final static String EMAIL_PATTERN = "^(([^<>()\\[\\]\\\\éèàâê=+%/$^*ù%§?!&|.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\éèàâê=+%/$^*ù%§?!&|.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

    //French number pattern can be with or without internalional prefix (0033/+33)
    private final static String FRENCH_PHONE_PATTERN = "^(?:(?:\\+|00)33|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$";


    /**
     * Generic method to check if a string matches with a given regular expression
     * @param validator the validator (regular expression)
     * @param toValidate the string needed to be checked
     * @return true if the string matches the regular expression
     */
    public static boolean validString (String validator, String toValidate )
    {
        Pattern pattern = Pattern.compile(validator);
        Matcher matcher = pattern.matcher(toValidate);
        return matcher.matches();
    }

    /**
     * Method to check if a given String is an email using Email regular expression pattern
     * @param email the given string to validate
     * @return true if he email given in parameter is an email
     */
    public static boolean isValidEmail(String email)
    {
        return validString(EMAIL_PATTERN, email);
    }

    public static boolean isValidFrenchNumber(String phone)
    {
        return validString(FRENCH_PHONE_PATTERN, phone);
    }

    public static boolean isValidPassword(String password)
    {
        return validString(PASSWORD_PATTERN, password);
    }

    public static String generateStringWithPattern(String pattern)
    {
        Xeger generator = new Xeger(pattern);
        return generator.generate();

    }



}
