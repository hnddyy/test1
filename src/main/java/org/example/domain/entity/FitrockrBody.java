package org.example.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "fitrockr_body")
@IdClass(FitrockrBodyId.class)
@DynamicUpdate
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class FitrockrBody implements Serializable {

    @Serial
    private static final long serialVersionUID = 1815498205812954911L;

    @Id
    @Column(name = "user_id", nullable = false, length = 255)
    private String userId;
    @Id
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "start_date_time")
    private LocalDateTime startDateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "end_date_time")
    private LocalDateTime endDateTime;
    private String id;
    @Column(name = "external_id", length = 255)
    private String externalId;
    @Column(name = "summary_id", length = 255)
    private String summaryId;
    private String tags; // day sleep, night sleep, nap or rem sleep
    private Boolean outdated;
    private String source;
    private String type;
    @Column(name = "activity_type")
    private String activityType;
    private Integer amount;
    private String unit;
    private Integer calories;
    private Integer distance;
    private Integer steps;
    private Integer value;
    @Column(name = "vo2_max")
    private Integer vo2Max;
    @Column(name = "fitness_age")
    private Integer fitnessAge;
    @Column(name = "active_calories")
    private Integer activeCalories;
    @Column(name = "active_seconds")
    private Integer activeSeconds;
    @Column(name = "met_value")
    private Integer metValue;
    private String intensity;
    @Column(name = "motion_intensity")
    private Integer motionIntensity;
    @Column(name = "mean_motion_intensity")
    private Integer meanMotionIntensity;
    @Column(name = "max_motion_intensity")
    private Integer maxMotionIntensity;
    private Integer stress;
    @Column(name = "avg_stress_level")
    private Integer averageStressLevel;
    @Column(name = "max_stress_level")
    private Integer maxStressLevel;
    @Column(name = "min_heartrate_bpm")
    private Integer minHeartRateInBeatsPerMinute;
    @Column(name = "avg_heartrate_bmp")
    private Integer avgHeartRateInBeatsPerMinute;
    @Column(name = "max_heartrate_bmp")
    private Integer maxHeartRateInBeatsPerMinute;
    @Column(name = "stress_level_value")
    private Integer stressLevelValue;
    @Column(name = "avg_intensity")
    private Integer averageIntensity;
    @Column(name = "body_battery")
    private Integer bodyBattery;
    @Column(name = "body_battery_status")
    private Integer bodyBatteryStatus;
    @Column(name = "calendar_date")
    private String calendarDate;
    private Integer duration;
    @Column(name = "duration_sec")
    private Integer durationInSeconds;
    @Column(name = "start_time_sec")
    private Integer startTimeInSeconds;
    @Column(name = "start_time_offset_sec")
    private Integer startTimeOffsetInSeconds;
    @Column(name = "timestamp_ms")
    private Integer timestampMs;
    @Column(name = "offset_sec")
    private Integer offsetInSec;
    @Column(name = "step_count")
    private Integer stepCount;
    @Column(name = "total_count")
    private Integer totalCount;
    @Column(name = "deel_sleep_duration_sec")
    private Integer deepSleepDurationInSeconds;
    @Column(name = "light_sleep_duration_sec")
    private Integer lightSleepDurationInSeconds;
    @Column(name = "awake_dration_sec")
    private Integer awakeDurationInSeconds;
    @Column(name = "rem_sleep_sec")
    private Integer remSleepSeconds;
    @Column(name = "unmeasurable_sec")
    private Integer unmeasurableSeconds;
    @Column(name = "sleep_sec")
    private Integer sleepSeconds;
    @Column(name = "sleep_efficiency")
    private Integer sleepEfficiency;
    private String validation;
    private Integer timestamp;
    @Column(name = "sleep_level_type")
    private String sleepLevelType;
    @Column(name = "sleep_start_time_sec")
    private Integer sleepStartTimeInSeconds;
    @Column(name = "sleep_end_time_sec")
    private Integer sleepEndTimeInSeconds;
    @Column(name = "sleep_duration")
    private Integer sleepDuration;

}