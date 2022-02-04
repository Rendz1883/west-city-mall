package io.github.ireflux.westcitymall.util;


import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author Dominick Li
 * @CreateTime 2020/3/29 17:56
 * @description 操作dfs 工具类
 **/
@Component
public class FileDfsUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileDfsUtil.class);

    @Resource
    private FastFileStorageClient storageClient;



    /**
     * 上传文件
     */
    public void upload() throws Exception {

        byte[] bytes = "fdsfdfaf".getBytes(StandardCharsets.UTF_8);
        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);

        StorePath storePath = storageClient.uploadFile(byteStream,bytes.length,"fdfdfsd",null);

        System.out.println(storePath.getFullPath());
    }


    /**
     * 删除文件
     */
    public void deleteFile(String fileUrl, boolean hasThumbnail) {

    }

    /**
     * 下载文件
     */
    public byte[] downloadFile(String fileUrl) {
        byte[] bt = {'d','d'} ;
        return bt;

    }
}

