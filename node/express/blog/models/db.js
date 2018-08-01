var settings = require('../settings');
var mongodb = require('mongodb');    //引入mongodb模块
var server = new mongodb.Server('localhost', settings.port, {auto_reconnect: true});
var db = new mongodb.Db(settings.db, server, {safe: true});

module.exports = db;