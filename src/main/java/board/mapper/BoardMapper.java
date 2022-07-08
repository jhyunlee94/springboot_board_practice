package board.mapper;

import java.util.List;

import board.dto.BoardFileDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import board.dto.BoardDto;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BoardMapper {
    List<BoardDto> selectBoardList() throws Exception;

//    @Insert("INSERT INTO t_board(title, contents, created_datetime, creator_id)VALUE(#{title},#{contents},NOW(),'admin')")
    void insertBoard(BoardDto board) throws Exception;

    @Update("UPDATE t_board SET hit_cnt = hit_cnt + 1 WHERE board_idx = #{boardIdx}")
    void updateHitCount(int boardIdx) throws Exception;

    @Select("SELECT board_idx, title, contents, hit_cnt, created_Datetime, creator_id FROM t_board WHERE board_idx = ${boardIdx} AND deleted_yn = 'N'")
    BoardDto selectBoardDetail(int boardIdx) throws Exception;

    void updateBoard(BoardDto board) throws Exception;

    void deleteBoard(int boardIdx) throws Exception;

    void insertBoardFileList(List<BoardFileDto> list) throws Exception;
}