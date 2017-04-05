/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package nio.thriftNio.server;

import nio.thriftNio.process.TProcessor;
import nio.thriftNio.transport.TServerTransport;

/**
 * Generic interface for a Thrift server.
 *
 */
public abstract class TServer {

  public static class Args extends AbstractServerArgs<Args> {
    public Args(TServerTransport transport) {
      super(transport);
    }
  }
  /**用来处理server中的输入输出的 trasport 和序列化协议Tprotocol Factory类*/
  public static abstract class AbstractServerArgs<T extends AbstractServerArgs<T>> {
    final TServerTransport serverTransport; /**具体server实现，普通的serverSocket；NonblockingServer*/


    public AbstractServerArgs(TServerTransport transport) {
      serverTransport = transport;
    }


  }

  /**
   * Core processor
   */
  protected TProcessor processor;

  /**
   * Server transport   server接口  socketServer nioServer
   */
  protected TServerTransport serverTransport_;



  private boolean isServing; /**状态标志*/


  // Flag for stopping the server
  // Please see THRIFT-1795 for the usage of this flag https://issues.apache.org/jira/browse/THRIFT-1795
  protected volatile boolean stopped_ = false;

  protected TServer(AbstractServerArgs args) {
    serverTransport_ = args.serverTransport;

  }

  /**
   * The run method fires up the server and gets things going.
   */
  public abstract void serve();

  /**
   * Stop the server. This is optional on a per-implementation basis. Not
   * all servers are required to be cleanly stoppable.
   */
  public void stop() {}

  public boolean isServing() {
    return isServing;
  }

  protected void setServing(boolean serving) {
    isServing = serving;
  }



  public boolean getShouldStop() {
    return this.stopped_;
  }

  public void setShouldStop(boolean shouldStop) {
    this.stopped_ = shouldStop;
  }
}
