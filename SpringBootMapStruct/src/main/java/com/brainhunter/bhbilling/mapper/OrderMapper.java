package com.brainhunter.bhbilling.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.brainhunter.bhbilling.dto.OrderDetailDto;
import com.brainhunter.bhbilling.entity.OrderDetail;

@Mapper
public interface OrderMapper {

	OrderDetailDto toOrderDetailDto(OrderDetail orderDetail);

	List<OrderDetailDto> toOrderDetailDtos(List<OrderDetail> orderDetails);

	OrderDetail toOrderDetail(OrderDetailDto orderDetailDto);

}
