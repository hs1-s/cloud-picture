package com.jiaxin.cloudpicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jiaxin.cloudpicturebackend.model.dto.space.SpaceAddRequest;
import com.jiaxin.cloudpicturebackend.model.dto.space.SpaceQueryRequest;
import com.jiaxin.cloudpicturebackend.model.entity.Space;
import com.jiaxin.cloudpicturebackend.model.entity.User;
import com.jiaxin.cloudpicturebackend.model.vo.SpaceVO;


import javax.servlet.http.HttpServletRequest;

/**
* @author qing
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2025-08-23 14:14:56
*/
public interface SpaceService extends IService<Space> {


    /**
     * 新增空间
     * @param spaceAddRequest
     * @param loginUser
     * @return
     */
    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);

    /**
     * 校验空间
     *
     * @param space
     * @param isAdd
     */
    void validSpace(Space space, boolean isAdd);

    /**
     * 获取空间包装类（单条）
     *
     * @param space
     * @param request
     * @return
     */
    SpaceVO getSpaceVO(Space space, HttpServletRequest request);

    /**
     * 获取空间包装类（分页）
     *
     * @param spacePage
     * @param request
     * @return
     */
    Page<SpaceVO> getSpaceVOPage(Page<Space> spacePage, HttpServletRequest request);

    /**
     * 获取查询对象
     *
     * @param spaceQueryRequest
     * @return
     */
    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);

    /**
     * 自动填充根据空间级别填值
     * @param space
     */
    void fillSpaceBySpaceLevel(Space space);

    /**
     * 检查当前用户是否为空间主人或者管理员
     * @param loginUser
     * @param space
     */
    void checkSpaceAuth(User loginUser, Space space);
}
