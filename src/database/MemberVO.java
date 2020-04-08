package database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class MemberVO {
	//memberTbl 내용 담기
	private int no;
	private String name;
	private int age ;
	private String gemder;

}
