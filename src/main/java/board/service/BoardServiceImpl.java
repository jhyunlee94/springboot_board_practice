package board.service;

import board.common.FileUtils;
import board.dto.BoardDto;
import board.dto.BoardFileDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;
import java.util.List;



@Slf4j
@Service
@Transactional
public class BoardServiceImpl implements BoardService {
    @Autowired
    private board.mapper.BoardMapper boardMapper;

    @Autowired
    private FileUtils fileUtils;

    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return boardMapper.selectBoardList();
    }

    @Override
    public void insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        boardMapper.insertBoard(board);

        List<BoardFileDto> list = fileUtils.parseFileInfo(board.getBoardIdx(), multipartHttpServletRequest);
        if (CollectionUtils.isEmpty(list) == false) {
            boardMapper.insertBoardFileList(list);
        }
//
//        if(ObjectUtils.isEmpty(multipartHttpServletRequest) == false){ // ObjectUtils.isEmpty() : null 체크와 빈 문자열 체크 동시에
//            Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
//            String name;
//            while (iterator.hasNext()){ //Iterator 자바 컬렉션,, 저장되어있는 요소들을 읽어오는 방법 표준화, hasNext() 읽어올 요소가 남아있는지 확인 있으면 true, 없으면 false
//                name = iterator.next(); // 다음 데이터를 name에 반환
//                log.debug("file tag name {}" , name);
//                List<MultipartFile> list2 = multipartHttpServletRequest.getFiles(name);
//                for(MultipartFile multipartFile : list2) {
//                    log.debug("start file information");
//                    log.debug("file name : " + multipartFile.getOriginalFilename());
//                    log.debug("file size : " + multipartFile.getSize());
//                    log.debug("file content type : " + multipartFile.getContentType());
//                    log.debug("end file information.\n");
//                }
//            }
//        }
    }

    @Override
    public BoardDto selectBoardDetail(int boardIdx) throws Exception {
        boardMapper.updateHitCount(boardIdx); // 선택된 게시글의 조회수 증가
        BoardDto board = boardMapper.selectBoardDetail(boardIdx); // 선택된 게시글의 내용을 조회
        return board;
    }

    @Override
    public void updateBoard(BoardDto board) throws Exception {
        boardMapper.updateBoard(board);
    }

    @Override
    public void deleteBoard(int boardIdx) throws Exception {
        boardMapper.deleteBoard(boardIdx);
    }


}
