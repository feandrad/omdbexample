package feandrad.ombdexample.utils.security;

import java.security.InvalidParameterException;

import feandrad.ombdexample.utils.string.StringHelper;

/**
 * Created by feandrad on 31/08/16.
 */
public class SecurityUtils {
	
	private static final String LOG_TAG = SecurityUtils.class.getSimpleName();
	
	public static String criptPass(String entry) {
		int length = entry.length();
		
		if (length < 3) {
			throw new InvalidParameterException("Password should have more than 3 characters.");
		}
		
		return sha1(entry + "_" + entry.substring(length - 3, length));
	}
	
	public static String sha1(String text) {
		return StringHelper.computeSha1OfString(text);
	}
	
}
