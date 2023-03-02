# Install Mongodb On Windows. [Full Documentation](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-ubuntu/)
# 1. Import the public key used by the package management system.
```shell
wget -qO - https://www.mongodb.org/static/pgp/server-6.0.asc | sudo apt-key add -
```
The operation should respond with an OK.

However, if you receive an error indicating that gnupg is not installed, you can:
Install gnupg and its required libraries using the following command:
```shell
sudo apt-get install gnupg
```
Once installed, retry importing the key:
```shell
wget -qO - https://www.mongodb.org/static/pgp/server-6.0.asc | sudo apt-key add -
```
```shell
wget -qO - https://www.mongodb.org/static/pgp/server-6.0.asc | sudo apt-key add -
```
# 2. Create a list file for MongoDB.
```shell
echo "deb [ arch=amd64,arm64 ] https://repo.mongodb.org/apt/ubuntu jammy/mongodb-org/6.0 multiverse" | sudo tee /etc/apt/sources.list.d/mongodb-org-6.0.list
```
# 3. Reload local package database.
```shell
sudo apt-get update
```
# 4. Install the MongoDB packages.
```shell
sudo apt-get install -y mongodb-org
```
----
# 1. Start MongoDB.
```shell
sudo systemctl start mongod
```
# 2. Verify that MongoDB has started successfully.
```shell
sudo systemctl status mongod
```
```shell
sudo systemctl enable mongod
```
# 3. Stop MongoDB.
```shell
sudo systemctl stop mongod
```
# 4. Restart MongoDB.
```shell
sudo systemctl restart mongod
```
----
# 1. Begin using MongoDB.
```shell
mongosh
```

