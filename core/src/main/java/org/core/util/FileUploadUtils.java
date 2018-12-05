package org.core.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

// TODO: Auto-generated Javadoc
/**
 * The Class FileUploadUtils.
 */
public class FileUploadUtils {

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	/**
	 * Upload file.
	 *
	 * @param imageInBytes
	 *            the image in bytes
	 * @param request
	 *            the request
	 * @return the string
	 */
	public static String UploadFile(byte[] imageInBytes, String path) {
		try (FileOutputStream outputStream = new FileOutputStream(path)) {
			outputStream.write(imageInBytes);

		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);

		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}

		return path;
	}

	/**
	 * Decode.
	 *
	 * @param base64Image
	 *            the base 64 image
	 * @return the byte[]
	 */
	public static byte[] decode(String base64Image) {

		if (base64Image != null || !"".equals(base64Image)) {
			return Base64.getDecoder().decode(base64Image);

		}
		return null;

	}
	


	/**
	 * Gets the base path.
	 *
	 * @param request
	 *            the request
	 * @return the base path
	 */
	public static String getBasePath(HttpServletRequest request) {
		
		String realpath = request.getSession().getServletContext().getRealPath("/");
		File workSpace= new File(realpath);
		String imagePath = workSpace.getParentFile().getPath() + File.separatorChar+ "web"+File.separatorChar+"image-dir";

		File imageDirectory = new File(imagePath);
		if (!imageDirectory.exists()) {
			imageDirectory.mkdirs();
		}
		return imagePath;
	}
	
	
	public static String byteToPath(HttpServletRequest request) {
		
		String realpath = request.getSession().getServletContext().getRealPath("/");
		File workSpace= new File(realpath);
		String imagePath = workSpace.getParentFile().getPath() + File.separatorChar+ "web"+File.separatorChar+"image-dir";

		File imageDirectory = new File(imagePath);
		if (!imageDirectory.exists()) {
			imageDirectory.mkdirs();
		}
		return imagePath;
	}

	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

}
