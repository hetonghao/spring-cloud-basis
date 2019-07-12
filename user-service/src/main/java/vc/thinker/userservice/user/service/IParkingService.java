package vc.thinker.userservice.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vc.thinker.userservice.user.entity.PkCarPark;
import vc.thinker.userservice.user.service.fallback.ParkingServiceFallback;

/**
 * @author HeTongHao
 * @since 2019-07-04 10:37
 */
@FeignClient(value = "parking-service", fallback = ParkingServiceFallback.class)
public interface IParkingService {
    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("parking/pkCarPark/detail/{id}")
    PkCarPark detail(@PathVariable("id") Long id);
}
