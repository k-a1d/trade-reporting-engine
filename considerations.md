# Code

- Reactive web over web MVC (blocking, synchronous).
- Chain-of-responsibility pattern to enable easier maintenance of filters
- Synchronous nature of XML parsing (not using reactor core or utilising java threading model) diminishes performance
  that could be reaped by parallel processing of files. Only accepting because of the small number of files.
- Storage model needs to be separated from event model for loose coupling.

# System Design

- Not using MQ due to limited time and scale of problem. Storing files locally instead for java application to parse XML
  under specific folder
- Using H2 DB because its in-memory and integrates well with Spring boot. Trade-off is non-persistent data because we're
  not hosting a separate database server on-prem or on the cloud. Limited scalability. Insecure credentials (stored in
  repo). Volatile Memory.

# To-do

- Add api spec
- Dockerisation to spin up DB instance (?)
