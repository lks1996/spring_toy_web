package toy.review.service;

import org.springframework.transaction.annotation.Transactional;
import toy.review.domain.Board;
import toy.review.domain.Comments;
import toy.review.repository.BoardRepository;

import java.util.List;
import java.util.Optional;

@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    /* 게시글 등록 */
    public String registration(Board board) {
        boardRepository.save(board);
        return board.getTitle();
    }


    /* 전체 게시글 조회 */
    public List<Board> findAllBoards() {
        return boardRepository.findAll();
    }

    /* 특정 게시글 검색(아이디로) */
    public Board findOneBoardById(Long boardId) {
        return boardRepository.findByBoardId(boardId);
    }

    /* 특정 게시글 검색(제목으로) */
    public List<Board> findBoardByTitle(String keyword) {
        return boardRepository.findByTitle(keyword);
    }

    public Comments registerComments(Comments comments) {
        return boardRepository.saveComments(comments);
    }
}
