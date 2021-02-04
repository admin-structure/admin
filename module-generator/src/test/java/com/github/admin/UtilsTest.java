package com.github.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Rule;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Ref;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @version v0.1
 * @Autheror wanglei
 */
class UtilsTest {
    @Test
    void getRuleByStartDate() {
        List<RefundRule> rules = new ArrayList<>();
        rules.add(new RefundRule(3, 3, 1, 100, LocalTime.of(0, 0, 0)));
        rules.add(new RefundRule(1, 3, 2, 80, LocalTime.of(0, 0, 0)));
        rules.add(new RefundRule(3, 3, 999999, 90, LocalTime.of(0, 0, 0)));


        LocalDateTime startDateTime = LocalDateTime.of(2020, 02, 04, 11, 13, 00);
        RefundRule rule = getMatchRule(startDateTime, rules);
        System.out.println(rule);
    }

    private RefundRule getMatchRule(LocalDateTime startDateTime, List<RefundRule> rules) {
        RefundRule currentRule = null;

        RefundRule rule = null;
        for (int i = 0; i < rules.size(); i++) {
            rule = rules.get(i);

            if (null != rule.getEndTime()) {
                LocalDateTime ruleTime = LocalDateTime.of(startDateTime.toLocalDate().plusDays(-(rule.getTimeToLeave() / 24)), rule.getEndTime());
                if (LocalDateTime.now().compareTo(ruleTime) >= 0) {
                    currentRule = rule;
                    break;
                }
            }

            if (LocalDateTime.now().compareTo(startDateTime.plusHours(-rule.getTimeToLeave())) >= 0) {
                currentRule = rule;
                break;
            }
        }

        if (null == currentRule) {
            throw new RuntimeException("未找到匹配的退款规则！");
        }

        return currentRule;
    }

    class RefundRule {
        private Integer id; // 主键，自动增长
        private int ruleId;// 规则id(对应的规则)1.旅行退票2.长途3.短途4.城际专车5.免收费6.不能退票,和线路，订单中的字段一致
        private int timeToLeave; // 离班次发车时间多久之内，单位：小时
        private int ruleScale; // 退款面分比例,0到100
        private LocalTime endTime; // 退票结束时间

        public RefundRule(Integer id, int ruleId, int timeToLeave, int ruleScale, LocalTime endTime) {
            this.id = id;
            this.ruleId = ruleId;
            this.timeToLeave = timeToLeave;
            this.ruleScale = ruleScale;
            this.endTime = endTime;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public int getRuleId() {
            return ruleId;
        }

        public void setRuleId(int ruleId) {
            this.ruleId = ruleId;
        }

        public int getTimeToLeave() {
            return timeToLeave;
        }

        public void setTimeToLeave(int timeToLeave) {
            this.timeToLeave = timeToLeave;
        }

        public int getRuleScale() {
            return ruleScale;
        }

        public void setRuleScale(int ruleScale) {
            this.ruleScale = ruleScale;
        }

        public LocalTime getEndTime() {
            return endTime;
        }

        public void setEndTime(LocalTime endTime) {
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "RefundRule{" +
                    "id=" + id +
                    ", ruleId=" + ruleId +
                    ", timeToLeave=" + timeToLeave +
                    ", ruleScale=" + ruleScale +
                    ", endTime=" + endTime +
                    '}';
        }
    }
}