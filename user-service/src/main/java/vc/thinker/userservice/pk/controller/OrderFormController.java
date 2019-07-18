package vc.thinker.userservice.pk.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vc.thinker.common.response.SimpleResponse;
import vc.thinker.userservice.pk.service.IOrderFormService;
import vc.thinker.userservice.pk.entity.OrderForm;
import vc.thinker.userservice.pk.vo.OrderFormPageVO;
import vc.thinker.common.response.PageResponse;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author HeTongHao
 * @since 2019-07-18
 */
@Api(tags = {""})
@RestController
@RequestMapping("pk/orderForm")
public class OrderFormController {
    @Autowired
    private IOrderFormService targetService;

    @ApiOperation(value = "分页查询")
    @PostMapping("page")
    public PageResponse page(@RequestBody @Valid OrderFormPageVO vo) {
        IPage page = vo.generatePage();
        targetService.page(page, vo);
        return new PageResponse().init(page);
    }


    @ApiOperation(value = "根据id查询")
    @GetMapping("{id}")
    public OrderForm detail(@PathVariable("id") Long id) {
        return targetService.getById(id);
    }

    @ApiOperation(value = "保存")
    @PatchMapping
    public OrderForm save(@RequestBody OrderForm orderForm) {
        targetService.save(orderForm);
        return null;
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public SimpleResponse delete(@PathVariable("id") Long id) {
        targetService.removeById(id);
        return new SimpleResponse();
    }
}
