package com.jiaxin.cloudpicturebackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiaxin.cloudpicturebackend.model.entity.Picture;
import com.jiaxin.cloudpicturebackend.service.PictureService;
import com.jiaxin.cloudpicturebackend.mapper.PictureMapper;
import org.springframework.stereotype.Service;

/**
* @author qing
* @description 针对表【picture(图片)】的数据库操作Service实现
* @createDate 2025-07-29 10:10:31
*/
@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture>
    implements PictureService{

}




