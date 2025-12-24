package com.back.global.jpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
@Getter
public class BaseIdAndTimeManual extends BaseEntity {
	@Id
	private int id;
	private LocalDateTime createTime;
	private LocalDateTime modifyTime;
}
