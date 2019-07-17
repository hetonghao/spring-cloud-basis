package vc.thinker.userservice.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vc.thinker.common.response.PageResponse;
import vc.thinker.userservice.user.entity.SysUser;
import vc.thinker.userservice.user.service.ISysUserService;
import vc.thinker.userservice.user.vo.SysUserVO;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author HeTongHao
 * @since 2019-07-03
 */
@Slf4j
@Api(tags = {"用户表"})
@RestController
@RequestMapping("user/sysUser")
public class SysUserController {
    @Autowired
    private ISysUserService targetService;
    @Autowired
    private Mapper mapper;

    /**
     * 查询分页数据
     */
    @ApiOperation(value = "查询分页数据")
    @PostMapping("page")
    public PageResponse page(@RequestBody @Valid SysUserVO vo) {
        PageResponse resp = new PageResponse();
        IPage page = vo.generatePage();
        targetService.page(page, vo);
        return resp.init(page);
    }


    /**
     * 根据id查询
     */
    @ApiOperation(value = "根据id查询数据")
    @GetMapping("detail/{id}")
    public SysUser detail(@PathVariable("id") Long id) {
        return targetService.findDetail(id);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "新增数据")
    @PatchMapping("save")
    public SysUser save(@RequestBody SysUser sysUser) {
        return null;
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @DeleteMapping("delete")
    public String delete(@RequestParam("ids") List<String> ids) {
        return null;
    }
}
