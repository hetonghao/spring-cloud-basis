package vc.thinker.userservice.user.service.fallback;

import org.springframework.stereotype.Component;
import vc.thinker.userservice.user.entity.PkCarPark;
import vc.thinker.userservice.user.service.IParkingService;

/**
 * @author HeTongHao
 * @since 2019-07-04 10:37
 */
@Component
public class ParkingServiceFallback implements IParkingService {
    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public PkCarPark detail(Long id) {
        return new PkCarPark().setCarParkName("默认停车场");
    }
}
