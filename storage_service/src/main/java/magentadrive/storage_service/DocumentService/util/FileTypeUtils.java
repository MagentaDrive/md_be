package magentadrive.storage_service.DocumentService.util;


import cn.hutool.core.io.FileTypeUtil;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * Util Class to get the type of an uploaded File.
 * Return a String
 */
public class FileTypeUtils {

    private final static String IMAGE_TYPE = "image/";
    private final static String VIDEO_TYPE = "video/";
    private final static String APPLICATION_TYPE = "application/";
    private final static String TXT_TYPE = "text/";

    public static String getFileType(MultipartFile multipartFile)  {

        String[] acceptedImageType = {"JPG", "JPEG", "GIF", "PNG"};
        String[] acceptedvideoType = {"mp4", "avi", "WMV", "mov"};
        String[] acceptedapplicationType = {"doc", "docx", "ppt", "pptx","xls", "xlsx", "zip", "jar","pdf"};


        InputStream inputStream = null;
       String type;
        try {
            inputStream = multipartFile.getInputStream();
            type = FileTypeUtil.getType(inputStream);

            for (var _type : acceptedImageType) {
                if( type.equalsIgnoreCase(_type))
                {
                    return IMAGE_TYPE + type;
                }
            }

            for (var _type : acceptedvideoType) {
                if( type.equalsIgnoreCase(_type))
                {
                    return VIDEO_TYPE + type;
                }

            }for (var _type : acceptedapplicationType) {
                if( type.equalsIgnoreCase(_type))
                {
                    return APPLICATION_TYPE + type;
                }
            }

            if (type.equalsIgnoreCase("txt")) {
                return TXT_TYPE + type;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
