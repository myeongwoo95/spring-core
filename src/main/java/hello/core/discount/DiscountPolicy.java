package hello.core.discount;


import hello.core.member.Member;

public interface DiscountPolicy {
    /**
     *
     * @param member
     * @param price
     * @return 정액할인 정액 금액액     */
    int discount(Member member, int price);

}
