package protocolsupport.protocol.transformer.middlepacketimpl.clientbound.play.v_1_5_1_6;

import java.util.Collection;
import java.util.Collections;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.ClientBoundPacket;
import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.transformer.middlepacket.clientbound.play.MiddleSpawnPosition;
import protocolsupport.protocol.transformer.middlepacketimpl.PacketData;
import protocolsupport.protocol.transformer.middlepacketimpl.SupportedVersions;

@SupportedVersions({ProtocolVersion.MINECRAFT_1_6_4, ProtocolVersion.MINECRAFT_1_6_2, ProtocolVersion.MINECRAFT_1_5_2})
public class SpawnPosition extends MiddleSpawnPosition<Collection<PacketData>> {

	@Override
	public Collection<PacketData> toData(ProtocolVersion version) {
		PacketDataSerializer serializer = PacketDataSerializer.createNew(version);
		serializer.writeInt(position.getX());
		serializer.writeInt(position.getY() + 1);
		serializer.writeInt(position.getZ());
		return Collections.singletonList(new PacketData(ClientBoundPacket.PLAY_SPAWN_POSITION_ID, serializer));
	}

}
