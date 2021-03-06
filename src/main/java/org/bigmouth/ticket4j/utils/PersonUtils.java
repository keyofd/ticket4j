package org.bigmouth.ticket4j.utils;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.bigmouth.ticket4j.entity.Person;
import org.bigmouth.ticket4j.entity.Seat;
import org.springframework.util.CollectionUtils;


public final class PersonUtils {

    private PersonUtils() {
    }
    
    /**
     * @param persons 乘车人列表
     * @param seat 将购买的席别
     * @param seatTypes {@linkplain org.bigmouth.ticket4j.entity.train.TrainDetails#getSeat_types()}
     * @return
     */
    public static String toPassengerTicketStr(List<Person> persons, Seat seat, String seatTypes) {
        if (CollectionUtils.isEmpty(persons))
            return null;
        StringBuilder result = new StringBuilder(128);
        for (Person person : persons) {
            result.append(person.toPassengerTicketStr(seat, seatTypes)).append("_");
        }
        return StringUtils.substring(result.toString(), 0, result.length() - 1);
    }
    
    public static String toOldPassengerTicket(List<Person> persons, Seat seat, String seatTypes) {
        StringBuilder result = new StringBuilder(128);
        for (Person person : persons) {
            result.append(person.toPassengerTicket(seat, seatTypes)).append("_");
        }
        return StringUtils.substring(result.toString(), 0, result.length() - 1);
    }
}
