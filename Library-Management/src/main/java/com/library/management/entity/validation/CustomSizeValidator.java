package com.library.management.entity.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import com.library.management.util.ApplicationProperties;


public class CustomSizeValidator implements ConstraintValidator<CustomSize, String> {

	private String maxKey;
	private String minKey;

	@Override
	public void initialize(CustomSize customSize) {
		this.maxKey = customSize.maxKey();
		this.minKey = customSize.minKey();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		int maxValue = Integer.parseInt(ApplicationProperties.INSTANCE.getValue(maxKey));
		int minValue = Integer.parseInt(ApplicationProperties.INSTANCE.getValue(minKey));
		if (StringUtils.isEmpty(value) || value.length() < minValue || value.length() > maxValue) {
			return false;
		} 
		return true;
	}
}

