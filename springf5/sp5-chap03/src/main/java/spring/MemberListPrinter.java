package spring;

import java.util.Collection;

public class MemberListPrinter {
	
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	// 생성자 의존성 주입
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao=memberDao;
		this.printer=printer;
	}
	
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m->printer.print(m));
	}

}
