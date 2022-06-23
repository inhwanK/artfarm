package org.hustar.artfarm.controller;

import io.swagger.annotations.*;
import org.hustar.artfarm.dto.notice.NoticeResponseDto;
import org.hustar.artfarm.dto.notice.NoticeSaveRequestDto;
import org.hustar.artfarm.dto.notice.NoticeUpdateRequestDto;
import org.hustar.artfarm.service.NoticeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "공지사항 정보 처리 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class RestNoticeController {

    private final NoticeService noticeService;

    @ApiOperation(value = "공지사항 목록 가져오기")
    @ApiImplicitParam(name = "pageable", value = "pageable 인터페이스 필드 입력해야함")
    @ApiResponses(
            @ApiResponse(code = 200, message = "공지사항 목록 가져오기 성공")
    )
    @GetMapping("/notice")
    public Page<NoticeResponseDto> getNoticeList(@ApiIgnore @PageableDefault(size = 10) Pageable pageable) {
        return noticeService.getNoticeList(pageable);
    }

    @ApiOperation(value = "공지사항 세부사항 가져오기")
    @ApiResponses(
            @ApiResponse(code = 200, message = "공지사항 세부사항 가져오기 성공")
    )
    @GetMapping("/notice/{noticeIdx}")
    public NoticeResponseDto getNotice(@ApiParam(value = "공지사항 번호") @PathVariable Long noticeIdx) {
        return noticeService.getNotice(noticeIdx);
    }

    @ApiOperation(value = "공지사항 등록")
    @ApiResponses(
            @ApiResponse(code = 200, message = "공지사항 등록 성공")
    )
    @PostMapping("/notice")
    public Long registerNotice(@ApiParam(value = "공지사항 요청 DTO") @RequestBody NoticeSaveRequestDto dto) {
        return noticeService.registerNotice(dto);
    }

    @ApiOperation(value = "공지사항 수정")
    @ApiResponses(
            @ApiResponse(code = 200, message = "공지사항 수정 성공")
    )
    @PutMapping("/notice/{noticeIdx}")
    public Long updateNotice(@ApiParam(value = "수정할 공지사항 번호") @PathVariable Long noticeIdx,
                             @ApiParam(value = "수정할 공지사항 데이터") @RequestBody NoticeUpdateRequestDto dto) {

        return noticeService.updateNotice(noticeIdx, dto);
    }

    @ApiOperation(value = "공지사항 삭제")
    @ApiResponses(
            @ApiResponse(code = 200, message = "공지사항 삭제 성공")
    )
    @DeleteMapping("/notice/{noticeIdx}")
    public Long deleteNotice(@ApiParam(value = "삭제할 공지사항 번호") @PathVariable Long noticeIdx) {
        return noticeService.deleteNotice(noticeIdx);
    }
}
