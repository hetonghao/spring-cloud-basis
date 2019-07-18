package vc.thinker.userservice.pk.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vc.thinker.userservice.pk.service.IOrderFormService;
import vc.thinker.userservice.pk.entity.OrderForm;
import vc.thinker.userservice.pk.vo.OrderFormPageVO;
import vc.thinker.common.response.PageResponse;
import vc.thinker.common.response.SingleResponse;
import vc.thinker.common.response.SimpleResponse;
import com.baomidou.mybatisplus.core.metadata.IPage;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
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
    public SingleResponse detail(@PathVariable("id") Long id) {
        return new SingleResponse().setItem(targetService.getById(id));
    }

    @ApiOperation(value = "保存")
    @PatchMapping
    public SingleResponse save(@RequestBody OrderForm orderForm) {
        targetService.save(orderForm);
        return detail(orderForm.getId());
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public SimpleResponse delete(@PathVariable("id") Long id) {
        SimpleResponse response = new SimpleResponse();
        response.setSuccess(targetService.removeById(id));
        return response;
    }
}
