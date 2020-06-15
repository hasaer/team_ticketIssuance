package show;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TicketIssuanceRepository extends PagingAndSortingRepository<TicketIssuance, Long>{

    TicketIssuance findByBookId(Integer bookId);

}