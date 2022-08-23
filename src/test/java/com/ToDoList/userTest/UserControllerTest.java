//package com.ToDoList.userTest;
//
//import com.ToDoList.user.controller.UserControllerStub;
//import com.ToDoList.user.entity.User;
//import com.google.gson.Gson;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.domain.*;
//import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
//import org.springframework.http.MediaType;
//import org.springframework.restdocs.payload.JsonFieldType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
//import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
//import static org.springframework.restdocs.payload.PayloadDocumentation.*;
//import static org.springframework.restdocs.request.RequestDocumentation.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(UserControllerStub.class)
//@MockBean(JpaMetamodelMappingContext.class)
//@AutoConfigureRestDocs
//public class UserControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private Gson gson;
//
//    @Test
//    void postTest() throws Exception {
//        User user = new User( "hhw", "abc@gmail.com", User.Role.USER);
//
//        User response = new User(1L, "hhw", "abc@gmail.com", User.Role.USER);
//
//        String content = gson.toJson(user);
//
//        ResultActions actions = mockMvc.perform(
//                post("/user")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(content));
//
//        actions.andExpect(status().isCreated())
//                .andExpect(jsonPath("$.data.userId").value(response.getUserId()))
//                .andExpect(jsonPath("$.data.name").value(response.getName()))
//                .andExpect(jsonPath("$.data.email").value(response.getEmail()))
//                .andExpect(jsonPath("$.data.role").value(response.getRole().name()))
//                .andDo(document("post-user",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("name").type(JsonFieldType.STRING).description("회원 이름"),
//                                        fieldWithPath("email").type(JsonFieldType.STRING).description("회원 이메일"),
//                                        fieldWithPath("role").type(JsonFieldType.STRING).description("회원 권한")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("user"),
//                                        fieldWithPath("data.userId").type(JsonFieldType.NUMBER).description("userId").ignored(), //회원 식별자 ignored처리
//                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("회원 이름"),
//                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("회원 이메일"),
//                                        fieldWithPath("data.role").type(JsonFieldType.STRING).description("권한")
//                                )
//                        )));
//    }
//
//    @Test
//    void patchTest() throws Exception {
//        User user = new User( "hhw", "abc@gmail.com", User.Role.USER);
//
//        User response = new User(1L, "hhw", "abc@gmail.com", User.Role.USER);
//
//        String content = gson.toJson(user);
//
//        ResultActions actions = mockMvc.perform(
//                patch("/user/{userId}",1)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(content));
//
//        actions.andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.userId").value(response.getUserId()))
//                .andExpect(jsonPath("$.data.name").value(response.getName()))
//                .andExpect(jsonPath("$.data.email").value(response.getEmail()))
//                .andExpect(jsonPath("$.data.role").value(response.getRole().name()))
//                .andDo(document("patch-user",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("name").type(JsonFieldType.STRING).description("회원 이름").optional(),
//                                        fieldWithPath("email").type(JsonFieldType.STRING).description("회원 이메일").optional(),
//                                        fieldWithPath("role").type(JsonFieldType.STRING).description("회원 권한").optional()
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("user"),
//                                        fieldWithPath("data.userId").type(JsonFieldType.NUMBER).description("userId").ignored(), //회원 식별자 ignored처리
//                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("회원 이름"),
//                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("회원 이메일"),
//                                        fieldWithPath("data.role").type(JsonFieldType.STRING).description("권한")
//                                )
//                        )));
//    }
//
//    @Test
//    void getUserTest() throws Exception {
//        Long userId = 1L;
//        User response = new User(1L, "hhw", "abc@gmail.com", User.Role.USER);
//
//
//
//        ResultActions actions = mockMvc.perform(
//                get("/user/{user-id}",userId)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        );
//
//        actions.andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.userId").value(response.getUserId()))
//                .andExpect(jsonPath("$.data.name").value(response.getName()))
//                .andExpect(jsonPath("$.data.email").value(response.getEmail()))
//                .andExpect(jsonPath("$.data.role").value(response.getRole().name()))
//                .andDo(document("get-user",
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(parameterWithName("user-id").description("회원 식별자")),
//
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("user"),
//                                        fieldWithPath("data.userId").type(JsonFieldType.NUMBER).description("userId").ignored(), //회원 식별자 ignored처리
//                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("회원 이름"),
//                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("회원 이메일"),
//                                        fieldWithPath("data.role").type(JsonFieldType.STRING).description("권한")
//                                )
//                        )));
//    }
//
//    @Test
//    void getUserListTest() throws Exception {
//
//        User response = new User(1L, "hhw","abc@gmail.com", User.Role.USER);
//        int page = 0; int size = 10;
//        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC,"userId");
//        List<User> list = new ArrayList<>(); list.add(response);
//        Page<User> pageList = new PageImpl<>(list,pageable,list.size());
//
//        ResultActions actions = mockMvc.perform(
//                get("/user")
//                        .param("page", String.valueOf(page))
//                        .param("size", String.valueOf(size))
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        );
//
//        actions.andExpect(status().isOk())
//                .andExpect(jsonPath("$.data").isArray())
//                .andExpect(jsonPath("$.pageInfo.page").value(page))
//                .andExpect(jsonPath("$.pageInfo.size").value(size))
//                .andExpect(jsonPath("$.pageInfo.totalElements").value(pageList.getTotalElements()))
//                .andExpect(jsonPath("$.pageInfo.totalPages").value(pageList.getTotalPages()))
//                .andDo(document("get-users",
//                        preprocessResponse(prettyPrint()),
//                        requestParameters(
//                                parameterWithName("page").description("페이지"),
//                                parameterWithName("size").description("크기")
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.ARRAY).description("회원 정보"),
//                                        fieldWithPath("data.[]userId").type(JsonFieldType.NUMBER).description("회원 식별자"),
//                                        fieldWithPath("data.[]name").type(JsonFieldType.STRING).description("회원 이름"),
//                                        fieldWithPath("data.[]email").type(JsonFieldType.STRING).description("회원 이메일"),
//                                        fieldWithPath("data.[]role").type(JsonFieldType.STRING).description("회원 권한"),
//                                        fieldWithPath("pageInfo").type(JsonFieldType.OBJECT).description("페이지 정보"),
//                                        fieldWithPath("pageInfo.page").type(JsonFieldType.NUMBER).description("page"),
//                                        fieldWithPath("pageInfo.size").type(JsonFieldType.NUMBER).description("size"),
//                                        fieldWithPath("pageInfo.totalElements").type(JsonFieldType.NUMBER).description("totalElements"),
//                                        fieldWithPath("pageInfo.totalPages").type(JsonFieldType.NUMBER).description("totalPages")
//                                )
//                        )));
//    }
//
//    @Test
//    void deleteTest() throws Exception {
//
//
//        ResultActions actions = mockMvc.perform(
//                delete("/user/{user-id}",1)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        );
//
//        actions.andExpect(status().isNoContent())
//
//                .andDo(document("delete-user",
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(
//                                parameterWithName("user-id").description("회원 식별자")
//                        )
//                        ));
//    }
//}
