package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.config.JwtService;
import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.UserResponses;
import peaksoft.entity.Basket;
import peaksoft.entity.User;
import peaksoft.repository.BasketRepository;
import peaksoft.repository.UserRepository;
import peaksoft.service.BasketService;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final BasketRepository basketRepository;
//    public BoardResponse saveBoard(BoardRequest request) {
//        User authenticatedUser = getAuthentication();
//        Board board = Board.builder()
//                .name(request.name())
//                .imageLink(request.imageLink())
//                .createdAt(ZonedDateTime.now())
//                .creator(authenticatedUser)
//                .build();
//
//        boardRepository.save(board);
//        authenticatedUser.getBoards().add(board);
//
//        return BoardResponse.builder()
//                .id(board.getId())
//                .name(board.getName())
//                .imageLink(board.getImageLink())
//                .createdAt(board.getCreatedAt())
//                .build();
//    }

    @Override
    public SimpleResponse saveBasket() {
        User authenticationUser = jwtService.getAuthentication();
        Basket basket=Basket.builder()
                .user()
                .build();
        return null;
    }

//    User authenticatedUser = getAuthentication();
//    List<BoardResponse> userBoardResponses = new ArrayList<>();
//    List<Board> all = boardRepository.findAll();
//
//        for (Board b : all) {
//        if (b.getCreator().equals(authenticatedUser)) {
//            BoardResponse response = BoardResponse.builder()
//                    .id(b.getId())
//                    .name(b.getName())
//                    .imageLink(b.getImageLink())
//                    .createdAt(b.getCreatedAt())
//                    .build();
//            userBoardResponses.add(response);
//        }
//    }
    @Override
    public UserResponses getAllBasket() {
        User authenticationUser = jwtService.getAuthentication();
        List<Basket> all=basketRepository.findAll();


        for (Basket b:all) {
            if(b.getUser().equals(authenticationUser)){

            }

        }
        return null;
    }

    @Override
    public SimpleResponse updateBasket(Long id, UserRequest userRequest) {

        return null;
    }

    @Override
    public UserResponses getBasketById(Long id) {
        return null;
    }

    @Override
    public SimpleResponse deleteById(Long id) {
        return null;
    }
}
