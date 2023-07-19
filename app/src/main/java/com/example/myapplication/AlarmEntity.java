package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;



public class AlarmEntity implements Parcelable {
    private long id;
    @NonNull
    private String object = "";//闹钟/日程
    @NonNull
    private String date = "";//20210305
    @NonNull
    private String date_origin = "";//今天
    @NonNull
    private String time = "";//05:00:00
    @NonNull
    private String timeInterval = "";//相对时间,例如5分钟:00:05:00
    @NonNull
    private String period = "";
    @NonNull
    private String ampm = "";//上午/下午
    @NonNull
    private String event = "";//提醒的事件
    @NonNull
    private String repeat = "";//W1W2W3W4W5
    private int enable = 0; //0代表闹钟打开 -1代表闹钟关闭

    @NonNull
    private Long lastModifiedTime; // 闹钟更新添加时间

    public AlarmEntity() {
    }

    protected AlarmEntity(Parcel in) {
        id = in.readLong();
        object = in.readString();
        date = in.readString();
        date_origin = in.readString();
        time = in.readString();
        timeInterval = in.readString();
        period = in.readString();
        ampm = in.readString();
        event = in.readString();
        repeat = in.readString();
        enable = in.readInt();
        lastModifiedTime = in.readLong();
    }

    public static final Creator<AlarmEntity> CREATOR = new Creator<AlarmEntity>() {
        @Override
        public AlarmEntity createFromParcel(Parcel in) {
            return new AlarmEntity(in);
        }

        @Override
        public AlarmEntity[] newArray(int size) {
            return new AlarmEntity[size];
        }
    };

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @NonNull
    public String getObject() {
        return object;
    }

    public void setObject(@NonNull String object) {
        this.object = object;
    }

    @NonNull
    public String getDate() {
        return date;
    }

    public void setDate(@NonNull String date) {
        this.date = date;
    }

    @NonNull
    public String getDate_origin() {
        return date_origin;
    }

    public void setDate_origin(@NonNull String date_origin) {
        this.date_origin = date_origin;
    }

    @NonNull
    public String getTime() {
        return time;
    }

    public void setTime(@NonNull String time) {
        this.time = time;
    }

    @NonNull
    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(@NonNull String timeInterval) {
        this.timeInterval = timeInterval;
    }

    @NonNull
    public String getPeriod() {
        return period;
    }

    public void setPeriod(@NonNull String period) {
        this.period = period;
    }

    @NonNull
    public String getAmpm() {
        return ampm;
    }

    public void setAmpm(@NonNull String ampm) {
        this.ampm = ampm;
    }

    @NonNull
    public String getEvent() {
        return event;
    }

    public void setEvent(@NonNull String event) {
        this.event = event;
    }

    @NonNull
    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(@NonNull String repeat) {
        this.repeat = repeat;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(@NonNull int enable) {
        this.enable = enable;
    }

    @NonNull
    public Long getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(@NonNull Long lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    @Override
    public String toString() {
        return "AlarmEntity{" +
            "id=" + id +
            ", object='" + object + '\'' +
            ", date='" + date + '\'' +
            ", date_origin='" + date_origin + '\'' +
            ", time='" + time + '\'' +
            ", timeInterval='" + timeInterval + '\'' +
            ", period='" + period + '\'' +
            ", ampm='" + ampm + '\'' +
            ", event='" + event + '\'' +
            ", repeat='" + repeat + '\'' +
            ", enable='" + enable + '\'' +
            ", lastModifiedTime='" + lastModifiedTime + '\'' +
            '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(object);
        dest.writeString(date);
        dest.writeString(date_origin);
        dest.writeString(time);
        dest.writeString(timeInterval);
        dest.writeString(period);
        dest.writeString(ampm);
        dest.writeString(event);
        dest.writeString(repeat);
        dest.writeInt(enable);
        dest.writeLong(lastModifiedTime);
    }
}
