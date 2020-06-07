package show;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="TicketIssuance_table")
public class TicketIssuance {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer bookId;
    private String issueStatus;

    @PrePersist
    public void onPrePersist(){
        IssueStatusChanged issueStatusChanged = new IssueStatusChanged();
        BeanUtils.copyProperties(this, issueStatusChanged);
        issueStatusChanged.publishAfterCommit();


        Issued issued = new Issued();
        BeanUtils.copyProperties(this, issued);
        issued.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
    public String getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }




}
