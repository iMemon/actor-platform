package im.actor.core.api.updates;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import im.actor.runtime.bser.*;
import im.actor.runtime.collections.*;
import static im.actor.runtime.bser.Utils.*;
import im.actor.core.network.parser.*;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import com.google.j2objc.annotations.ObjectiveCName;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import im.actor.core.api.*;

public class UpdateUserOffline extends Update {

    public static final int HEADER = 0x8;
    public static UpdateUserOffline fromBytes(byte[] data) throws IOException {
        return Bser.parse(new UpdateUserOffline(), data);
    }

    private int uid;
    private ApiDeviceType deviceType;
    private String deviceCategory;

    public UpdateUserOffline(int uid, @Nullable ApiDeviceType deviceType, @Nullable String deviceCategory) {
        this.uid = uid;
        this.deviceType = deviceType;
        this.deviceCategory = deviceCategory;
    }

    public UpdateUserOffline() {

    }

    public int getUid() {
        return this.uid;
    }

    @Nullable
    public ApiDeviceType getDeviceType() {
        return this.deviceType;
    }

    @Nullable
    public String getDeviceCategory() {
        return this.deviceCategory;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.uid = values.getInt(1);
        int val_deviceType = values.getInt(2, 0);
        if (val_deviceType != 0) {
            this.deviceType = ApiDeviceType.parse(val_deviceType);
        }
        this.deviceCategory = values.optString(3);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeInt(1, this.uid);
        if (this.deviceType != null) {
            writer.writeInt(2, this.deviceType.getValue());
        }
        if (this.deviceCategory != null) {
            writer.writeString(3, this.deviceCategory);
        }
    }

    @Override
    public String toString() {
        String res = "update UserOffline{";
        res += "uid=" + this.uid;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
