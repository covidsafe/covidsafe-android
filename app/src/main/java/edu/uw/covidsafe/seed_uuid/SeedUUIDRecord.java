package edu.uw.covidsafe.seed_uuid;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.apache.commons.codec.digest.Crypt;

import edu.uw.covidsafe.utils.CryptoUtils;

@Entity(tableName = "seed_uuid_record_table")
public class SeedUUIDRecord {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "ts")
    public long ts;

    @NonNull
    @ColumnInfo(name = "seed")
    private String seedEncrypted;

    @NonNull
    @ColumnInfo(name = "uuid")
    private String uuidEncrypted;

    public SeedUUIDRecord(@NonNull long ts, String seedEncrypted, String uuidEncrypted) {
        this.ts = ts;
        setSeed(seedEncrypted);
        setUUID(uuidEncrypted);
    }

    public long getTs() { return this.ts; }

    public String getSeedEncrypted() { return this.seedEncrypted; }

    public String getSeed() { return CryptoUtils.decrypt(this.seedEncrypted); }

    public void setSeed(String seed) { this.seedEncrypted = CryptoUtils.encrypt(seed); }

    public String getUuidEncrypted() { return this.uuidEncrypted; }

    public String getUUID() { return this.uuidEncrypted; }

    public void setUUID(String uuid) { this.uuidEncrypted = CryptoUtils.encrypt(uuid); }

}
