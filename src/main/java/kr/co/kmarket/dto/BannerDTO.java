package kr.co.kmarket.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BannerDTO {
    private int banner_no;
    private String banner_name;
    private String img;
    private String link;
    private String location;
    private Integer banner_order;
    private Integer banner_status;
    private String banner_size;
    private String background_color;
    private String start_date;
    private String end_date;
    private String start_time;
    private String end_time;

    private MultipartFile imgFile;
}
