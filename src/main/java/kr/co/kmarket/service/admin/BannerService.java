package kr.co.kmarket.service.admin;

import java.util.List;

import jakarta.transaction.Transactional;
import kr.co.kmarket.mapper.admin.BannerMapper;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import kr.co.kmarket.dto.BannerDTO;

@Service
@RequiredArgsConstructor
public class BannerService {
    private final BannerMapper mapper;

    public List<BannerDTO> selectBanners() {
        return mapper.selectBanners();
    }

    @Transactional
    public void insertBanner(BannerDTO dto) {
        mapper.insertBanner(dto);
    }

    @Transactional
    public void updateBannerStatus(int banner_no, int status) {
        mapper.updateBannerStatus(banner_no, status);
    }

    public void deleteBanners(List<Integer> bannerNos) {
        mapper.deleteBanners(bannerNos);
    }

    public List<BannerDTO> getBannersByLocation(String location) {
        return mapper.selectBannersByLocation(location);
    }

}
