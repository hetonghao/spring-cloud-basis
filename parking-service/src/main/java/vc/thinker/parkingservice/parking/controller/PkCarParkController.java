package vc.thinker.parkingservice.parking.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vc.thinker.parkingservice.parking.entity.PkCarPark;
import vc.thinker.parkingservice.parking.service.IPkCarParkService;

import java.util.List;

/**
 * <p>
 * 停车场 前端控制器
 * </p>
 *
 * @author HeTongHao
 * @since 2019-07-03
 */
@Api(tags = {"停车场"})
@RestController
@RequestMapping("parking/pkCarPark")
public class PkCarParkController {
    @Autowired
    private IPkCarParkService targetService;

    /**
     * 查询分页数据
     */
    @ApiOperation(value = "查询分页数据")
    @PostMapping("page")
    public Page page(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum, @RequestParam(name = "pageSize", defaultValue = "20") int pageSize) {
        return null;
    }


    /**
     * 根据id查询
     */
    @ApiOperation(value = "根据id查询数据")
    @GetMapping("detail/{id}")
    public PkCarPark detail(@PathVariable("id") Long id) {
        return targetService.getById(id);
    }

    /**
     * 新增
     */
    @ApiOperation(value = "新增数据")
    @PatchMapping("save")
    public PkCarPark save(@RequestBody PkCarPark pkCarPark) {
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
