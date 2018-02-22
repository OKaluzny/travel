FROM germes/base:glassfish as maven3

FROM glassfish:5

ARG war_path

COPY --from=maven3 $war_path /glassfish5/glassfish/domains/domain1/autodeploy/
