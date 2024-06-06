package com.dongyoung.noAlone.meeting.repository.impl;

import com.dongyoung.noAlone.meeting.entity.Meeting;
import com.dongyoung.noAlone.meeting.model.FindResponseMeetingAndOwnerListModel;
import com.dongyoung.noAlone.meeting.model.FindResponseMeetingListModel;
import com.dongyoung.noAlone.meeting.model.SearchCondition;
import com.dongyoung.noAlone.meeting.model.mapper.MeetingMapper;
import com.dongyoung.noAlone.meeting.repository.MeetingQueryReposity;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.dongyoung.noAlone.meeting.entity.QMeeting.meeting;

@Log4j2
@Repository
@RequiredArgsConstructor
public class MeetingQueryRepository implements MeetingQueryReposity {

    private final JPAQueryFactory queryFactory;
    private final MeetingMapper meetingMapper;

    @Override
    public Page<FindResponseMeetingAndOwnerListModel> findAllByQueryDsl(SearchCondition search, Pageable pageable) {
        List<Meeting> list = queryFactory.selectFrom(meeting)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .where(search(search.name()))
                .orderBy(meeting.meetingId.desc())
                .fetch();

        JPAQuery<Long> count = queryFactory.select(Wildcard.count).from(meeting);
        return PageableExecutionUtils.getPage(list.stream().map(meetingMapper::toMeetingListModel).collect(Collectors.toList()),pageable,count::fetchCount);
    }

    private BooleanExpression search(String search) {
        return search != null ? meeting.name.contains(search) : null;
    }
}
