package org.company.controller;

import org.checkerframework.checker.tainting.qual.Tainted;
import org.company.repository.*;
import org.owasp.esapi.*;
import org.owasp.esapi.codecs.*;

public class UserController {

    private final UserRepository userRepo;

    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    User findUser(@Tainted String name) {
        UserDto userDto = userRepo.getUser(name);
        return convert(userDto);
    }

    private static String escaped(String name) {
        return ESAPI.encoder().encodeForSQL(new MySQLCodec(MySQLCodec.Mode.STANDARD), name);
    }

    User convert(UserDto userDto) {
        return new User(userDto.getName(), userDto.getSurname());
    }
}
