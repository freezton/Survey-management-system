package com.example.authentication.mapper;

import com.example.authentication.dto.UserDto;
import com.example.authentication.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<User, UserDto> {

}
