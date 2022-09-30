package com.platinosfood.backend.converters;

import com.platinosfood.backend.data.UserData;
import com.platinosfood.backend.entities.User;

public class UserConverter extends Converter<User, UserData> {

    private RoleConverter roleConverter = new RoleConverter();

    @Override
    public User toEntity(UserData object) {
        return object == null ? null : User.builder()
                .id(object.getId())
                .firstName(object.getFirstName())
                .lastName(object.getLastName())
                .email(object.getEmail())
                .password(object.getPassword())
                .phone(object.getPhone())
                .address(object.getAddress())
                .enable(object.isEnable())
                .registerDate(object.getRegisterDate())
                .accessDate(object.getAccessDate())
                //.role(roleConverter.toEntity(object.getRole()))
                .build();
    }

    @Override
    public UserData toData(User object) {
        return object == null ? null : UserData.builder()
                .id(object.getId())
                .firstName(object.getFirstName())
                .lastName(object.getLastName())
                .email(object.getEmail())
                .password(null)
                .phone(object.getPhone())
                .address(object.getAddress())
                .enable(object.isEnable())
                .registerDate(object.getRegisterDate())
                .accessDate(object.getAccessDate())
                //.role(roleConverter.toData(object.getRole()))
                .build();
    }

}
