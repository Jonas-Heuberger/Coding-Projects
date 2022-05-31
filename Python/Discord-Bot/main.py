import os
import discord
import requests
import json

client = discord.Client()

def get_quote():
  response = requests

@client.event
async def on_ready():
  print('We have logged in as {0.user}'
  .format(client))

@client.event
async def on_message(message):
  if message.author == client.user:
    return

  if message.content.startswith('$hello'):
    await message.channel.send('Hello!')

  if message.content.startswith('$hayd'):
    await message.channel.send('Great, how about you?')

  if message.content.startswith('$wiybf'):
    await message.channel.send('JH1814 is my best Friend!!!')

  if message.content.startswith('$version'):
    await message.channel.send('1.0')

  if message.content.startswith('$level'):
    await message.channel.send('1.0')

  if message.content.startswith('$author'):
    await message.channel.send('JH1814')


client.run(os.getenv('TOKEN'))

