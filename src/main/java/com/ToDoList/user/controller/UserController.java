package com.ToDoList.user.controller;

import com.ToDoList.dto.MultiResponseDto;
import com.ToDoList.dto.SingleResponseDto;
import com.ToDoList.user.entity.User;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/user")
@RestController
public class UserController {

    //test를 위한 스텁 데이터
    User user = new User(1L, "hhw","abc@gmail.com", User.Role.USER);

    @PostMapping //회원가입
    public ResponseEntity sign_up(@RequestBody User user) {

        return new ResponseEntity<>(new SingleResponseDto<>(this.user), HttpStatus.CREATED);
    }

    @PatchMapping("/{user-id}") //user정보 수정
    public ResponseEntity updateMember(@PathVariable("user-id")Long userId,
                                       @RequestBody User user) {
        return new ResponseEntity<>(new SingleResponseDto<>(this.user), HttpStatus.OK);
    }

    @GetMapping("/{user-id}") //user 조회
    public ResponseEntity getMember(@PathVariable("user-id") Long userId) {
        return new ResponseEntity<>(new SingleResponseDto<>(this.user), HttpStatus.OK);
    }

    @GetMapping//page로 user 전체 조회
    public ResponseEntity getMemberPage(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC);
        List<User> list = new ArrayList<>(); list.add(this.user);
        Page<User> pageList = new PageImpl<>(list,pageable,list.size());


        return new ResponseEntity<>(new MultiResponseDto<>(list, pageList),HttpStatus.OK);
    }

    @DeleteMapping("/{user-id}")//delete member
    public ResponseEntity deleteMember(@PathVariable("user-id")Long userId) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
