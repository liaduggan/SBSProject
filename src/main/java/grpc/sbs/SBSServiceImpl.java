// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: temperature.proto

package grpc.sbs;

public final class SBSServiceImpl {
  private SBSServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_temperature_tempRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_temperature_tempRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_temperature_currentTemperature_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_temperature_currentTemperature_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_temperature_tempSetRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_temperature_tempSetRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_temperature_tempSetResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_temperature_tempSetResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021temperature.proto\022\013temperature\"\036\n\013temp" +
      "Request\022\017\n\007message\030\001 \001(\t\"\"\n\022currentTempe" +
      "rature\022\014\n\004temp\030\001 \001(\005\"\036\n\016tempSetRequest\022\014" +
      "\n\004temp\030\001 \001(\005\"\"\n\017tempSetResponse\022\017\n\007messa" +
      "ge\030\001 \001(\t2\247\001\n\013TempService\022L\n\013tempReading\022" +
      "\030.temperature.tempRequest\032\037.temperature." +
      "currentTemperature\"\0000\001\022J\n\007tempSet\022\033.temp" +
      "erature.tempSetRequest\032\034.temperature.tem" +
      "pSetResponse\"\000(\0010\001B\034\n\010grpc.sbsB\016SBSServi" +
      "ceImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_temperature_tempRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_temperature_tempRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_temperature_tempRequest_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_temperature_currentTemperature_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_temperature_currentTemperature_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_temperature_currentTemperature_descriptor,
        new java.lang.String[] { "Temp", });
    internal_static_temperature_tempSetRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_temperature_tempSetRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_temperature_tempSetRequest_descriptor,
        new java.lang.String[] { "Temp", });
    internal_static_temperature_tempSetResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_temperature_tempSetResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_temperature_tempSetResponse_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
