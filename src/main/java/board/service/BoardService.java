// BoardService.java
package board.service;

import board.dto.BoardDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BoardService {

    List<BoardDto> selectBoardList() throws Exception;
    void insertBoard(BoardDto board) throws Exception;
    BoardDto selectBoardDetail(int boardIdx) throws Exception;
}
