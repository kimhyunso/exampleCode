package org.zerock.guestbook.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.guestbook.dto.GuestBookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.GuestBook;

@SpringBootTest
public class GuestBookServiceTests {
    @Autowired
    private GuestService service;

    @Test
    public void testRegister(){
        GuestBookDTO guestBookDTO = GuestBookDTO.builder()
                .title("Sample Title....")
                .content("Sample Content....")
                .writer("user0")
                .build();
        System.out.println(service.register(guestBookDTO));
    }

    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
        PageResultDTO<GuestBookDTO, GuestBook> resultDTO = service.getList(pageRequestDTO);

        System.out.println("PREV : "+resultDTO.isPrev());
        System.out.println("NEXT : "+resultDTO.isNext());
        System.out.println("TOTAL : "+resultDTO.getTotalPage());
        for(GuestBookDTO guestBookDTO : resultDTO.getDtoList()){
            System.out.println(guestBookDTO);
        }
        System.out.println("===============================");
        resultDTO.getPageList().forEach(i->System.out.println(i));

    }

}
